package com.app.user.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.app.user.config.helper.JwtUtil;
import com.app.user.service.CustomUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requesttoken=request.getHeader("Authorization");
		String jwtToken=null;
		if(null!=requesttoken && requesttoken.startsWith("Bearer ")) {
			jwtToken=requesttoken.substring(7);
			try {
				System.err.println("###########Token is:#"+jwtToken);
				String userName=jwtUtil.extractUsername(jwtToken);
				System.err.println("###########UserName is:#"+userName);
				UserDetails userDetails=customUserDetailsService.loadUserByUsername(userName);
				if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
			catch (ExpiredJwtException e) {
				System.err.println("Expired JWT token."+e);
	            //HANDLE IT HERE::::: wrap ExpiredJwtException in AuthenticationException and rethrow Exception
	           throw new CredentialsExpiredException("Expired jwt credentials ", e);

	        }
			catch (SignatureException e) {
				System.err.println("Expired JWT token."+e);
	            //HANDLE IT HERE::::: wrap ExpiredJwtException in AuthenticationException and rethrow Exception
	           throw new CredentialsExpiredException("Expired jwt credentials ", e);

	        }
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else {
			System.err.println("Token not found");
			
		}
		//All good then we are forwading request
		System.err.println("All Good" );
		filterChain.doFilter(request, response);
	}
	 

}
