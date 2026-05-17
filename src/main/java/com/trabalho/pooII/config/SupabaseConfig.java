package com.trabalho.pooII.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties(prefix = "supabase")
public class SupabaseConfig {

    private String url;
    private String key;
    private String bucket;

    @Bean
    public WebClient supabaseWebClient() {
        return WebClient.builder()
                .baseUrl(url + "/storage/v1")
                .defaultHeader("Authorization", "Bearer " + key)
                .build();
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getBucket() { return bucket; }
    public void setBucket(String bucket) { this.bucket = bucket; }
}
