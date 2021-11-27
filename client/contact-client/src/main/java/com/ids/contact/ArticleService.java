package com.ids.contact;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ArticleService", path = "/article", url = "${feign.contact.base-url}")
public interface ArticleService extends GenericFeignClient<Article, Long> {

}
