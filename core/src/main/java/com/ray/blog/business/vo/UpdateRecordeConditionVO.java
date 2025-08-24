package com.ray.blog.business.vo;

import com.ray.blog.business.entity.UpdateRecorde;
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
public class UpdateRecordeConditionVO extends BaseConditionVO {
	private UpdateRecorde updateRecorde;
}

