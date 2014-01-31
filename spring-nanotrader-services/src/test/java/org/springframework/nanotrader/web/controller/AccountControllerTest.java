/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.nanotrader.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.nanotrader.service.configuration.MappingConfig;
import org.springframework.nanotrader.service.configuration.ServiceConfig;
import org.springframework.nanotrader.web.configuration.ServiceTestConfiguration;
import org.springframework.nanotrader.web.configuration.TestServletContext;
import org.springframework.nanotrader.web.configuration.WebConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.ActiveProfiles;


/**
 * AccountControllerTest tests the Account REST api 
 * 
 * @author Brian Dussault
 * @author
 */

public class AccountControllerTest extends AbstractSecureControllerTest {

	@Test
	public void getQuoteBySymbolJson() throws Exception {
		mockMvc.perform(get("/account/" + ServiceTestConfiguration.ACCOUNT_ID).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.accountid").value(ServiceTestConfiguration.ACCOUNT_ID))
				.andExpect(jsonPath("$.creationdate").value(ServiceTestConfiguration.DATE))
				.andExpect(jsonPath("$.openbalance").value(ServiceTestConfiguration.ACCOUNT_OPEN_BALANCE.doubleValue()))
				.andExpect(jsonPath("$.logoutcount").value(ServiceTestConfiguration.LOGOUT_COUNT.intValue()))
				.andExpect(jsonPath("$.balance").value(ServiceTestConfiguration.ACCOUNT_BALANCE.doubleValue()))
				.andExpect(jsonPath("$.lastlogin").value(ServiceTestConfiguration.DATE))
				.andExpect(jsonPath("$.logincount").value(ServiceTestConfiguration.LOGIN_COUNT))
				.andDo(print());
	}
}