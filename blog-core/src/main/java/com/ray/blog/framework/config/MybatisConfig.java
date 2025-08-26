package com.ray.blog.framework.config;

import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://docs.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Component
@MapperScan("com.ray.blog.persistence.mapper")
public class MybatisConfig {
}
