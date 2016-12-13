package com.lottery.service.admin;

import com.lottery.guice.ServiceModule;

/**
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-07
 * Time: 14:06
 */
public class AdminServiceModule extends ServiceModule {
    @Override
    protected void configure() {
        bindService(IAdminDataService.class, AdminDataService.class);
    }
}
