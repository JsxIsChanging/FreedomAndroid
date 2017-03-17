package com.example.a91256.freedomandroid.bean;

/**
 * Created by 91256 on 2017/3/15.
 */

public class DataBean {
    /**
     * stateCode : 1
     * message : 成功
     * returnData : {"rankinglist":[{"title":"月票","subTitle":"来不及了快上车，老司机票选人气漫画，带你飞！","cover":"http://image.mylife.u17t.com/2016/12/28/1482920243_f2kF1UculvH7.jpg","argName":"sort","argValue":"23","rankingType":"月票值"},{"title":"点击","subTitle":"厉害了我的大触，原来大家都在这里看漫画！？","cover":"http://image.mylife.u17t.com/2016/12/28/1482920257_yznXvXJcrvk8.jpg","argName":"sort","argValue":"25","rankingType":"点击值"},{"title":"吐槽","subTitle":"不可描述的吐槽，画面太美，快来看看。","cover":"http://image.mylife.u17t.com/2016/12/28/1482920418_vA222B8m6qi3.jpg","argName":"sort","argValue":"20","rankingType":"吐槽值"},{"title":"新作","subTitle":"拒绝身体被掏空，人气新作为你补补血。","cover":"http://image.mylife.u17t.com/2016/12/28/1482920437_Cmg3we0vH3me.jpg","argName":"sort","argValue":"2","rankingType":"新作值"}]}
     */

    private int stateCode;
    private String message;
    private ReturnDataBean returnData;

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReturnDataBean getReturnData() {
        return returnData;
    }

    public void setReturnData(ReturnDataBean returnData) {
        this.returnData = returnData;
    }


}
