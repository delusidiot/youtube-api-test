package com.ssafy.youtube;

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
        var result = YouTubeDataAPI.getYouTubeService()
                .channels()
                .list("id,snippet,brandingSettings,contentDetails,invideoPromotion,statistics,topicDetails")
//                .setId("UCYfy5yVnG7l2vbTumjYYP9w")
                .setForUsername("NoCopyrightSounds")
                .execute();

        System.out.println(result);
    }

}
