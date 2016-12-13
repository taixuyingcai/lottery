package com.lottery.service.bill;

import com.lottery.guice.ServiceModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 票务注入
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-26
 * Time: 18:23
 */
public class BillServiceModule extends ServiceModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceModule.class);
    @Override
    protected void configure() {
        bind(IBillDataService.class).to(BillDataServiceImpl.class).asEagerSingleton();
        bindService(IBizAdmBillService.class, BizAdmBillServiceImpl.class);
    }

}
