package greendao.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "COMMENT_REPLY".
*/
public class CommentReplyDao extends AbstractDao<CommentReply, Long> {

    public static final String TABLENAME = "COMMENT_REPLY";

    /**
     * Properties of entity CommentReply.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property CommentSubId = new Property(1, long.class, "commentSubId", false, "COMMENT_SUB_ID");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property CreateTime = new Property(4, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property UserId = new Property(5, long.class, "userId", false, "USER_ID");
    }

    private DaoSession daoSession;

    private Query<CommentReply> comment_SubCommentsQuery;

    public CommentReplyDao(DaoConfig config) {
        super(config);
    }
    
    public CommentReplyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COMMENT_REPLY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"COMMENT_SUB_ID\" INTEGER NOT NULL UNIQUE ," + // 1: commentSubId
                "\"TITLE\" TEXT NOT NULL ," + // 2: title
                "\"CONTENT\" TEXT," + // 3: content
                "\"CREATE_TIME\" INTEGER NOT NULL ," + // 4: createTime
                "\"USER_ID\" INTEGER NOT NULL );"); // 5: userId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COMMENT_REPLY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CommentReply entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getCommentSubId());
        stmt.bindString(3, entity.getTitle());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
        stmt.bindLong(5, entity.getCreateTime().getTime());
        stmt.bindLong(6, entity.getUserId());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CommentReply entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getCommentSubId());
        stmt.bindString(3, entity.getTitle());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
        stmt.bindLong(5, entity.getCreateTime().getTime());
        stmt.bindLong(6, entity.getUserId());
    }

    @Override
    protected final void attachEntity(CommentReply entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public CommentReply readEntity(Cursor cursor, int offset) {
        CommentReply entity = new CommentReply( //
            cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // commentSubId
            cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // content
            new java.util.Date(cursor.getLong(offset + 4)), // createTime
            cursor.getLong(offset + 5) // userId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CommentReply entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setCommentSubId(cursor.getLong(offset + 1));
        entity.setTitle(cursor.getString(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCreateTime(new java.util.Date(cursor.getLong(offset + 4)));
        entity.setUserId(cursor.getLong(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CommentReply entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CommentReply entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CommentReply entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "subComments" to-many relationship of Comment. */
    public List<CommentReply> _queryComment_SubComments(long id) {
        synchronized (this) {
            if (comment_SubCommentsQuery == null) {
                QueryBuilder<CommentReply> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Id.eq(null));
                queryBuilder.orderRaw("T.'CREATE_TIME' ASC");
                comment_SubCommentsQuery = queryBuilder.build();
            }
        }
        Query<CommentReply> query = comment_SubCommentsQuery.forCurrentThread();
        query.setParameter(0, id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(" FROM COMMENT_REPLY T");
            builder.append(" LEFT JOIN USER T0 ON T.\"USER_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected CommentReply loadCurrentDeep(Cursor cursor, boolean lock) {
        CommentReply entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
         if(user != null) {
            entity.setUser(user);
        }

        return entity;    
    }

    public CommentReply loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<CommentReply> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<CommentReply> list = new ArrayList<CommentReply>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<CommentReply> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<CommentReply> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
