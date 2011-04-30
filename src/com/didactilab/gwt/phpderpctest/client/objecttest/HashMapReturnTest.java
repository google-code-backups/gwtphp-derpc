/*
 * Copyright 2011 DidactiLab SAS
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Date: 30 avr. 2011
 * Author: Mathieu LIGOCKI
 */
package com.didactilab.gwt.phpderpctest.client.objecttest;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class HashMapReturnTest extends ObjectTestCase {

	@Override
	protected void execute() {
		asyncWait();
		service.hashMapReturn(new AsyncCallback<HashMap<Integer, String>>() {
			@Override
			public void onFailure(Throwable caught) {
				asyncFail("Failure \n" + caught);
			}

			@Override
			public void onSuccess(HashMap<Integer, String> result) {
				boolean res = true;
				res &= result.get(0).equals("zero");
				res &= result.get(1).equals("one");
				res &= result.get(2).equals("two");
				res &= result.get(3).equals("three");
				asyncPassIf(res);
			}
		});
	}

	@Override
	public String getTitle() {
		return "Return HashMap<Integer, String>(0 => \"zero\" ... 3 => \"three\")";
	}

}