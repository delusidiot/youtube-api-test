package com.ssafy.youtube;

import com.google.api.services.youtube.model.ChannelListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class YouTubeRestController {

    @GetMapping(value = "/api/channels/{channelId}")
    public ChannelListResponse getChannels(@PathVariable("channelId") String channelId) throws IOException {

        var result = YouTubeDataAPI.getYouTubeService()
                .channels()
                .list("id,snippet,brandingSettings,contentDetails,invideoPromotion,statistics,topicDetails")
                .setId(channelId)
                .execute();

        return result;
    }
}
