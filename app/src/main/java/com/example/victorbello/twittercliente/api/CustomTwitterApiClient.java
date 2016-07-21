package com.example.victorbello.twittercliente.api;

/**
 * Created by victorbello on 20/07/16.
 */

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.Session;

public class CustomTwitterApiClient extends TwitterApiClient{

    public CustomTwitterApiClient(Session session) {
        super(session);
    }

    public TimeLineService getTimelineService(){
        return getService(TimeLineService.class);
    }
}
