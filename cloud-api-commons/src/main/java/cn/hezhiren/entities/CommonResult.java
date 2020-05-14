package cn.hezhiren.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : hezr
 * @description :
 * @date : 2020/04/28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T Data;

    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
