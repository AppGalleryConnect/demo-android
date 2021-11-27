/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
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

package com.huawei.agc.quickstart.appmessaging;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.huawei.agconnect.appmessaging.AGConnectAppMessaging;
import com.huawei.agconnect.common.api.AGCInstanceID;

public class AppMessagingActivity extends FragmentActivity {
    private AGConnectAppMessaging appMessaging;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appmessaging);
        appMessaging = AGConnectAppMessaging.getInstance();
        initView();
    }

    private void initView() {
        Button btnDebugMessage = findViewById(R.id.btn_debug);
        /*
         * Message test procedure
         */
        btnDebugMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * Step 1
                 * Obtain the AAID of the device and add the AAID to the AppGallery Connect server. For details, please refer to the development guide.
                 */
                AGCInstanceID agcInstanceID = AGCInstanceID.getInstance(AppMessagingActivity.this);
                String aaid = agcInstanceID.getId();

                /*
                 *  Step 2
                 *  Call the setForceFetch API.
                 *  Note: The API can be called only during version tests. Do not use it for officially released versions.
                 */
                appMessaging.setForceFetch();

                /*
                 * Step 3
                 * Trigger an event so the SDK can synchronize test device data from the AppGallery Connect server. (Ensure that the AAID of the test device has been added to the AppGallery Connect server.）
                 * For example, you can press Home to exit the app and open the app again at least one second later.
                 */

                /*
                 * Step 4
                 * Check logs to see if the test device has been added successfully.
                 * Log: This device is a test device
                 */
            }
        });

    }

}
