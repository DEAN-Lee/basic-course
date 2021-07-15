package org.deanlee.course.networkio.noblockingio;

import javax.validation.constraints.NotNull;
import java.util.Map;


public class OrderExtOpenNotifyRequest  {
    @NotNull(message = "outerOrderId  is null")
    private String outerOrderId;
    @NotNull(message = "orderNumber  is null")
    private String orderNumber;
    @NotNull(message = "payAmount  is null")
    private Integer payAmount;
    @NotNull(message = "notifyType  is null")
    private String notifyType;
    @NotNull(message = "updateStatus  is null")
    private Integer updateStatus;
    @NotNull(message = "timestamp  is null")
    private Long timestamp;
    private Map<String, String> extInfo;

    public String getOuterOrderId() {
        return outerOrderId;
    }

    public void setOuterOrderId(String outerOrderId) {
        this.outerOrderId = outerOrderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }


    public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

    public Map<String, String> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(Map<String, String> extInfo) {
        this.extInfo = extInfo;
    }
}
