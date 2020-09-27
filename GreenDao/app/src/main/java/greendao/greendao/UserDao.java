package greendao.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UserIncrId = new Property(1, Long.class, "userIncrId", false, "USER_INCR_ID");
        public final static Property UserAccount = new Property(2, String.class, "userAccount", false, "USER_ACCOUNT");
        public final static Property UserName = new Property(3, String.class, "userName", false, "USER_NAME");
        public final static Property OrgId = new Property(4, Long.class, "orgId", false, "ORG_ID");
        public final static Property OrgName = new Property(5, String.class, "orgName", false, "ORG_NAME");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USER_INCR_ID\" INTEGER UNIQUE ," + // 1: userIncrId
                "\"USER_ACCOUNT\" TEXT NOT NULL ," + // 2: userAccount
                "\"USER_NAME\" TEXT," + // 3: userName
                "\"ORG_ID\" INTEGER," + // 4: orgId
                "\"ORG_NAME\" TEXT);"); // 5: orgName
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long userIncrId = entity.getUserIncrId();
        if (userIncrId != null) {
            stmt.bindLong(2, userIncrId);
        }
        stmt.bindString(3, entity.getUserAccount());
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(4, userName);
        }
 
        Long orgId = entity.getOrgId();
        if (orgId != null) {
            stmt.bindLong(5, orgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(6, orgName);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long userIncrId = entity.getUserIncrId();
        if (userIncrId != null) {
            stmt.bindLong(2, userIncrId);
        }
        stmt.bindString(3, entity.getUserAccount());
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(4, userName);
        }
 
        Long orgId = entity.getOrgId();
        if (orgId != null) {
            stmt.bindLong(5, orgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(6, orgName);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // userIncrId
            cursor.getString(offset + 2), // userAccount
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // userName
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // orgId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // orgName
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserIncrId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setUserAccount(cursor.getString(offset + 2));
        entity.setUserName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setOrgId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setOrgName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}