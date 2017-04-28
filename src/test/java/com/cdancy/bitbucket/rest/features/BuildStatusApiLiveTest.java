/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cdancy.bitbucket.rest.features;

import com.cdancy.bitbucket.rest.BaseBitbucketApiLiveTest;
import com.cdancy.bitbucket.rest.domain.build.StatusPage;
import com.cdancy.bitbucket.rest.domain.build.Summary;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(groups = "live", testName = "BuildStatusApiLiveTest")
public class BuildStatusApiLiveTest extends BaseBitbucketApiLiveTest {

    @Test
    public void testGetStatusByNonExistentCommit() {
        StatusPage statusPage = api().status(randomString(),0,100);
        assertThat(statusPage).isNotNull();
        assertThat(statusPage.size() == 0).isTrue();
    }

    @Test
    public void testGetSummaryByNonExistentCommit() {
        Summary statusPage = api().summary(randomString());
        assertThat(statusPage).isNotNull();
        assertThat(statusPage.successful() == 0).isTrue();
        assertThat(statusPage.inProgress() == 0).isTrue();
        assertThat(statusPage.failed() == 0).isTrue();
    }

    private BuildStatusApi api() {
        return api.buildStatusApi();
    }
}