package com.app.user.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.constants.URLConstants;

@RestController
@CrossOrigin
@RequestMapping(value = URLConstants.MASTER_SERVICE)
public class MasterController {

}
