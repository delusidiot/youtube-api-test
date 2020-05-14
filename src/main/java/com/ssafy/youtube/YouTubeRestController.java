package com.ssafy.youtube;

import com.google.api.services.youtube.model.*;
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
    @GetMapping(value = "/api/subscriptions")
    public SubscriptionListResponse getSubscriptions() throws IOException {
        Long maxResult = 100L;
        var result = YouTubeDataAPI.getYouTubeService()
                .subscriptions()
                .list("id, snippet, contentDetails")
                .setMine(true)
                .setMaxResults(maxResult)
                .execute();
        var result2 = YouTubeDataAPI.getYouTubeService()
                .subscriptions()
                .list("id, snippet, contentDetails")
                .setMine(true)
                .setMaxResults(maxResult);
        System.out.println("subscription list : " + result.getItems());
        return result;
    }
    @GetMapping(value = "/api/playlists")
    public PlaylistListResponse getPlaylists() throws IOException {
        Long maxResult = 100L;
        var result = YouTubeDataAPI.getYouTubeService()
                .playlists()
                .list("id, snippet, status")
                .setMine(true)
                .execute();
        return result;
    }
    @GetMapping(value = "/api/liveBroadcasts")
    public LiveBroadcastListResponse getLiveBroadcasts() throws IOException {
        var result = YouTubeDataAPI.getYouTubeService()
                .liveBroadcasts()
                .list("snippet")
                .setId("VFhkX2GesZE")
                .execute();
        return result;
    }
    @GetMapping(value = "/api/liveMessages")
    public LiveChatMessageListResponse getLiveMessages() throws IOException {
        var result = YouTubeDataAPI.getYouTubeService()
                .liveChatMessages()
                .list("Cg0KC1ZGaGtYMkdlc1pFKicKGFVDcW1yUEQyZC01WFJOZHJLLWFOSWF2ZxILVkZoa1gyR2VzWkU","snippet")
                .execute();
        return result;
    }
    @GetMapping(value = "/api/search/{channelId}")
    public SearchListResponse getSearch(@PathVariable("channelId") String channelId) throws IOException {
        var result = YouTubeDataAPI.getYouTubeService()
                .search()
                .list("snippet")
                .setChannelId(channelId)
                .setEventType("live")
                .setType("video")
                .execute();
        return result;
    }
}
