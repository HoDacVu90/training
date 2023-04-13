package my.po.dao;

import com.axonivy.utils.persistence.dao.AuditableDAO;

import my.po.entities.Promote;
import my.po.entities.Promote_;

public class PromoteDAO extends AuditableDAO<Promote_, Promote> implements BaseDAO {
	
	private static final PromoteDAO instance = new PromoteDAO(); 

	private PromoteDAO() {
	}

	public static PromoteDAO getInstance() {
		return instance;
	}
	
	@Override
	protected Class<Promote> getType() {
		// TODO Auto-generated method stub
		return Promote.class;
	}

}