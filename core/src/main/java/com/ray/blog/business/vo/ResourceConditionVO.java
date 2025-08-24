package com.ray.blog.business.vo;

import com.ray.blog.business.entity.Resources;
import com.ray.blog.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://docs.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceConditionVO extends BaseConditionVO {
    private Resources resources;
}

