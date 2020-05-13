package com.ssafy.youtube;

import com.google.api.services.youtube.model.ChannelListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class YoutubeGradelDemoApplicationTests {

    /**
     * https://developers.google.com/youtube/v3/docs/channels?hl=ko
     */
    @Test
    public void channels() throws IOException {
        ChannelListResponse result = YouTubeDataAPI.getYouTubeService()
                .channels()
                .list("id,snippet,brandingSettings,contentDetails,invideoPromotion,statistics,topicDetails")
                .setForUsername("NoCopyrightSounds")
                .execute();
        System.out.println(result);
    }

}
