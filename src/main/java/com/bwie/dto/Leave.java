package com.bwie.dto;


/**
 * ��ٵ�ʵ��
 * @author user
 *
 */
public class Leave {

  private Integer id; // ���

  private String name; // �����

  private String leaveDate;// �������

  private Integer leaveDays; // �������

  private String leaveReason; // ���ԭ��

  private String state; // ���״̬  δ�ύ  ����� ���ͨ�� ���δͨ��

  private String processInstanceId; // ����ʵ��Id

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLeaveDate() {
    return leaveDate;
  }

  public void setLeaveDate(String leaveDate) {
    this.leaveDate = leaveDate;
  }

  public Integer getLeaveDays() {
    return leaveDays;
  }

  public void setLeaveDays(Integer leaveDays) {
    this.leaveDays = leaveDays;
  }

  public String getLeaveReason() {
    return leaveReason;
  }

  public void setLeaveReason(String leaveReason) {
    this.leaveReason = leaveReason;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getProcessInstanceId() {
    return processInstanceId;
  }

  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }

}
