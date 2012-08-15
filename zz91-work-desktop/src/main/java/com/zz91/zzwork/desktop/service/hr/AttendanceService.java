package com.zz91.zzwork.desktop.service.hr;


import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.zz91.zzwork.desktop.domain.hr.Attendance;
import com.zz91.zzwork.desktop.dto.PageDto;
import com.zz91.zzwork.desktop.dto.hr.WorkDay;

public interface AttendanceService {
 
	public Boolean impt(Date from, Date to ,InputStream inputStream);
	
	public PageDto<Attendance> pageAttendance(String name, String code, Date from, Date to, PageDto<Attendance> page );
	
	/**
	 * 当月应出勤天数：统计选定工作日
	 * 出勤天数：工作日内有打卡记录
	 * 
	 * 请假：无法判断，由HR填写，不在统计范围内
	 * 其他天数：无法判断，由HR定义与填写，不在统计范围内
	 * 
	 * 未打卡：无上班/下班时间记录
	 * 旷工：无记录=应出勤天数-出勤天数
	 * 迟到：上班时间>应上班时间
	 * 早退：下班时间<应下班时间
	 * 加班：下班时间>20:00
	 * @param month
	 * @param workDay
	 */
	public void analysis(Date month, List<WorkDay> workDay);
	
	public List<WorkDay> buildWorkday(Date month, Integer[] day, String[] workf, String[] workt);
	
	public List<WorkDay> buildworkDays(Date month);
}
 
