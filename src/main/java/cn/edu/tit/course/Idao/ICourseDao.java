package cn.edu.tit.course.Idao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Component;

import cn.edu.tit.course.bean.Accessory;
import cn.edu.tit.course.bean.Course;
import cn.edu.tit.course.bean.Depart;
import cn.edu.tit.course.bean.Task;

@Component
public interface ICourseDao {
	/**
	 * 添加课程
	 * @param course
	 * 创建课程名称、状态、介绍、教材、封面图片、所属学校 分类（标签）、适合专业
	 */
	public void addCourse(Course course);
	/**
	 * 获取某课程邀请码
	 * @param course_id
	 * 课程id
	 * @return
	 * 邀请码 & 创建者id
	 */
	public Course getverify(String invitation_code);
	
	/**
	 * 将申请者加入课程
	 * @param user_id
	 * 申请人id
	 * @param course_id
	 * 加入的课程
	 */
	public void joinCourse(@Param("user_id")String user_id,@Param("course_id")String course_id,@Param("create_user")String create_user);
	/**
	 * 为课程添加任务
	 * @param task
	 */
	public void addTask(Task task);
	
	/**
	 * 添加附件
	 * @param acc
	 */
	public void addAcc(Accessory acc);
	
	/**
	 * 通过id获取任务创建者id
	 * @param task_id
	 * 任务id
	 * @return
	 * 任务创建者id
	 */
	public String getTaskCreater(String task_id);
	
	/**
	 * 将提交的任务存到数据库
	 * @param task
	 */
	public void uploadTask(Task task);
	
	
	/*
	 * 课程查找
	 */
	
	/**
	 * 根据名字查找课程
	 * @param course_name
	 * 课程名
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByName(String course_name);
	
	/**
	 * 根据标签查找课程
	 * @param course_label
	 * 课程标签
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByLabel(String course_label);
	
	/**
	 * 根据适合专业查找课程
	 * @param application_pro
	 * 适合专业
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByAppro(String application_pro);
	
	/**
	 * 根据发布者查找课程
	 * @param creater
	 * 发布者
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByCreater(String creater);
	
	/**
	 * 根据学校查找课程
	 * @param college
	 * 学校
	 * @return
	 * 课程列表
	 */
	public List<Course> findCouByCollege(String college);
	
	/**
	 * 根据id查任务
	 * @param task_id
	 * @return
	 */
	public Task findTextByid(String task_id);
	
	/**
	 * 根据附件id查询附件路径
	 * @return
	 */
	public String getAccPath(String accessory_id);
	
	/**
	 * 根据task_id查找附件
	 * @param task_id
	 * @return
	 */
	public List<Accessory> getAccList(@Param("task_id")String task_id,@Param("kind") int kind);
	
	/**
	 * 根据id查提交任务
	 * @param task_id
	 * @return
	 */
	public List<Task> getUpbyid(String task_id);
	
	/**
	 * 根据task_id 和 user_id查找task
	 * @param task_id
	 * @param user_id
	 * @return
	 */
	public Task getupload(@Param("task_id")String task_id,@Param("user_id")String user_id); 
	/**
	 * 根据taskid查状态
	 * @param task_id
	 * @return
	 */
	public int findTaskStatus(String task_id);
	
	/**
	 * 根据taskid查成绩
	 * @param task_id
	 * @return
	 */
	public int findTaskGrade(@Param("task_id")String task_id,@Param("user_id")String user_id);
	
	/**
	 * 评分
	 * @param grade
	 * @param task_id
	 * @param user_id
	 */
	public void updategrade(@Param("grade")int grade, @Param("task_id")String task_id, @Param("user_id")String user_id);
	
	/**
	 * 根据标签查总记录数
	 * @param course_label
	 * @return
	 */
	public int getCNumByLable(String course_label);
	
	/**
	 * 分页查课程
	 * @param course_label
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Course> getCByPage(@Param("course_label")String course_label,@Param("begin")int begin,@Param("end")int end);
	
	/**
	 * 根据id查找课程
	 * @param course_id
	 * @return
	 */
	public Course findcByid(String course_id);
	
	/**
	 * 根据userID查找课程
	 * @param user_id
	 * @return
	 */
	public List<Course> findCByUserid(String user_id);
	
	/**
	 * 根据userID获得加入课程id
	 * @param user_id
	 * @return
	 */
	public List<String> findJoinCourseid(String user_id);
	
	/**
	 * 根据courseid查任务
	 * @param course_id
	 * @return
	 */
	public List<Task> getTaskBycid(String course_id);
	/**
	 * 获取所有系部
	 * @return
	 */
	public List<Depart> getDepart();
}
