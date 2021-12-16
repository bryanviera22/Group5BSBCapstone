package com.company.BriannaJohnsonCapstone.gameDao.controller;

import org.springframework.web.bind.annotation.RequestMethod;

public @interface RequestMapping {
    String value();

    RequestMethod method();
}
