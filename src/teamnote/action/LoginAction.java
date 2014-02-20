package teamnote.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;

import org.apache.struts2.interceptor.*;

import teamnote.domain.User;
import teamnote.service.UserService;

public class LoginAction extends UserBaseAction
{
	// ����һ��������ΪԱ����¼�ɹ���Result��
	private final String USR_RESULT = "usr";
	// ����һ��������Ϊ�����¼�ɹ���Result��
	private final String ADM_RESULT = "adm";

	// ��װ�������
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	// �����¼�����ʾ��Ϣ
	private String tip;

	// tip���Ե�setter��getter����
	public void setTip(String tip)
	{
		this.tip = tip;
	}

	public String getTip()
	{
		return this.tip;
	}

	// �����û�����
	public String execute() throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();

		// ����ҵ���߼������������¼����
		int result = userService.validLogin(getUser());
		// ��¼���Ϊ��ͨԱ��
		if (result == 1)
		{
			ctx.getSession().put("user", user.getUserName());
			setTip("���Ѿ��ɹ���¼ϵͳ");
			return USR_RESULT;
		}
		// ��¼���Ϊ����
		else if (result == 2)
		{
			ctx.getSession().put("user", user.getUserName());
			setTip("���Ѿ��ɹ���¼ϵͳ");
			return ADM_RESULT;
		}
		// �û��������벻ƥ��
		else
		{
			setTip("�û���/���벻ƥ��");
			return ERROR;
		}

	}
}