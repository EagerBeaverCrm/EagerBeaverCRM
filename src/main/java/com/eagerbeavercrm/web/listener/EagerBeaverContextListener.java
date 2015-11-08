package com.eagerbeavercrm.web.listener;

import com.eagerbeavercrm.modules.MainModule;
import com.eagerbeavercrm.web.filter.CrmFilter;
import com.eagerbeavercrm.web.filter.EagerBeaverPageFilter;
import com.eagerbeavercrm.web.servlet.IndexServlet;
import com.eagerbeavercrm.web.servlet.PageServe;
import com.eagerbeavercrm.web.servlet.PageServlet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import javax.servlet.Filter;
import javax.servlet.http.HttpServlet;

/**
 * Created by kimberlygrauer on 11/7/15.
 */
public class EagerBeaverContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {

        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                install(new MainModule());

                filter("/response").through(Key.get(Filter.class, CrmFilter.class));
                bind(Filter.class).annotatedWith(CrmFilter.class).to(EagerBeaverPageFilter.class).in(Singleton.class);

                serve("/response").with(Key.get(HttpServlet.class, PageServe.class));
                bind(HttpServlet.class).annotatedWith(PageServe.class).to(PageServlet.class);

                serve("/").with(IndexServlet.class);

            }
        });
    }

}
