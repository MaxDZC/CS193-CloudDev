package sample.meta;

<<<<<<< HEAD
//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-20 16:41:24")
=======
<<<<<<< HEAD
//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-20 14:01:55")
=======
//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-21 12:21:35")
>>>>>>> e0c0b6093691ae62be8eccd9e0a3939cb48fc972
>>>>>>> develop
/** */
public final class PatientModelMeta extends org.slim3.datastore.ModelMeta<sample.model.PatientModel> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> address = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "address", "address");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.util.Date> birthday = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.util.Date>(this, "birthday", "birthday", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> contactNo = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "contactNo", "contactNo");

    /** */
<<<<<<< HEAD
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> createdAt = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "createdAt", "createdAt");
=======
<<<<<<< HEAD
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> createdaAt = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "createdaAt", "createdaAt");
=======
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.util.Date> createdAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.util.Date>(this, "createdAt", "createdAt", java.util.Date.class);
>>>>>>> e0c0b6093691ae62be8eccd9e0a3939cb48fc972
>>>>>>> develop

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.util.Date> deletedAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.util.Date>(this, "deletedAt", "deletedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> firstname = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "firstname", "firstname");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> lastname = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "lastname", "lastname");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.lang.Boolean> sex = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.lang.Boolean>(this, "sex", "sex", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.util.Date> updatedAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.util.Date>(this, "updatedAt", "updatedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PatientModelMeta slim3_singleton = new PatientModelMeta();

    /**
     * @return the singleton
     */
    public static PatientModelMeta get() {
       return slim3_singleton;
    }

    /** */
    public PatientModelMeta() {
        super("PatientModel", sample.model.PatientModel.class);
    }

    @Override
    public sample.model.PatientModel entityToModel(com.google.appengine.api.datastore.Entity entity) {
        sample.model.PatientModel model = new sample.model.PatientModel();
        model.setAddress((java.lang.String) entity.getProperty("address"));
<<<<<<< HEAD
        model.setBirthday((java.util.Date) entity.getProperty("birthday"));
        model.setContactNo((java.lang.String) entity.getProperty("contactNo"));
        model.setCreatedAt((java.lang.String) entity.getProperty("createdAt"));
=======
<<<<<<< HEAD
        model.setBirthDay((java.lang.String) entity.getProperty("birthDay"));
        model.setContactNumber((java.lang.String) entity.getProperty("contactNumber"));
        model.setCreatedaAt((java.lang.String) entity.getProperty("createdaAt"));
>>>>>>> develop
        model.setDeletedAt((java.lang.String) entity.getProperty("deletedAt"));
        model.setFirstname((java.lang.String) entity.getProperty("firstname"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setLastname((java.lang.String) entity.getProperty("lastname"));
        model.setSex(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("sex")));
        model.setUpdatedAt((java.lang.String) entity.getProperty("updatedAt"));
<<<<<<< HEAD
=======
        model.setUserName((java.lang.String) entity.getProperty("userName"));
=======
        model.setBirthday((java.util.Date) entity.getProperty("birthday"));
        model.setContactNo((java.lang.String) entity.getProperty("contactNo"));
        model.setCreatedAt((java.util.Date) entity.getProperty("createdAt"));
        model.setDeletedAt((java.util.Date) entity.getProperty("deletedAt"));
        model.setFirstname((java.lang.String) entity.getProperty("firstname"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setLastname((java.lang.String) entity.getProperty("lastname"));
        model.setSex(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("sex")));
        model.setUpdatedAt((java.util.Date) entity.getProperty("updatedAt"));
>>>>>>> e0c0b6093691ae62be8eccd9e0a3939cb48fc972
>>>>>>> develop
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        sample.model.PatientModel m = (sample.model.PatientModel) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("address", m.getAddress());
        entity.setProperty("birthday", m.getBirthday());
        entity.setProperty("contactNo", m.getContactNo());
        entity.setProperty("createdAt", m.getCreatedAt());
        entity.setProperty("deletedAt", m.getDeletedAt());
        entity.setProperty("firstname", m.getFirstname());
        entity.setProperty("id", m.getId());
        entity.setProperty("lastname", m.getLastname());
        entity.setProperty("sex", m.isSex());
        entity.setProperty("updatedAt", m.getUpdatedAt());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        sample.model.PatientModel m = (sample.model.PatientModel) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        sample.model.PatientModel m = (sample.model.PatientModel) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        sample.model.PatientModel m = (sample.model.PatientModel) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        sample.model.PatientModel m = (sample.model.PatientModel) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        sample.model.PatientModel m = (sample.model.PatientModel) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAddress() != null){
            writer.setNextPropertyName("address");
            encoder0.encode(writer, m.getAddress());
        }
        if(m.getBirthday() != null){
            writer.setNextPropertyName("birthday");
            encoder0.encode(writer, m.getBirthday());
        }
        if(m.getContactNo() != null){
            writer.setNextPropertyName("contactNo");
            encoder0.encode(writer, m.getContactNo());
        }
        if(m.getCreatedAt() != null){
            writer.setNextPropertyName("createdAt");
            encoder0.encode(writer, m.getCreatedAt());
        }
        if(m.getDeletedAt() != null){
            writer.setNextPropertyName("deletedAt");
            encoder0.encode(writer, m.getDeletedAt());
        }
        if(m.getFirstname() != null){
            writer.setNextPropertyName("firstname");
            encoder0.encode(writer, m.getFirstname());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastname() != null){
            writer.setNextPropertyName("lastname");
            encoder0.encode(writer, m.getLastname());
        }
        writer.setNextPropertyName("sex");
        encoder0.encode(writer, m.isSex());
        if(m.getUpdatedAt() != null){
            writer.setNextPropertyName("updatedAt");
            encoder0.encode(writer, m.getUpdatedAt());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected sample.model.PatientModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        sample.model.PatientModel m = new sample.model.PatientModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("address");
        m.setAddress(decoder0.decode(reader, m.getAddress()));
        reader = rootReader.newObjectReader("birthday");
        m.setBirthday(decoder0.decode(reader, m.getBirthday()));
        reader = rootReader.newObjectReader("contactNo");
        m.setContactNo(decoder0.decode(reader, m.getContactNo()));
        reader = rootReader.newObjectReader("createdAt");
        m.setCreatedAt(decoder0.decode(reader, m.getCreatedAt()));
        reader = rootReader.newObjectReader("deletedAt");
        m.setDeletedAt(decoder0.decode(reader, m.getDeletedAt()));
        reader = rootReader.newObjectReader("firstname");
        m.setFirstname(decoder0.decode(reader, m.getFirstname()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastname");
        m.setLastname(decoder0.decode(reader, m.getLastname()));
        reader = rootReader.newObjectReader("sex");
        m.setSex(decoder0.decode(reader, m.isSex()));
        reader = rootReader.newObjectReader("updatedAt");
        m.setUpdatedAt(decoder0.decode(reader, m.getUpdatedAt()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}