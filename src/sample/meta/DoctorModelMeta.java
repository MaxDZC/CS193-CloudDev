package sample.meta;

<<<<<<< HEAD
//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-20 14:01:55")
=======
//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-21 12:21:35")
>>>>>>> e0c0b6093691ae62be8eccd9e0a3939cb48fc972
/** */
public final class DoctorModelMeta extends org.slim3.datastore.ModelMeta<sample.model.DoctorModel> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> address = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "address", "address");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.util.Date> birthday = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.util.Date>(this, "birthday", "birthday", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> contactNo = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "contactNo", "contactNo");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.util.Date> createdAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.util.Date>(this, "createdAt", "createdAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.util.Date> deletedAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.util.Date>(this, "deletedAt", "deletedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> email = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> firstname = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "firstname", "firstname");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.lang.Boolean> admin = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.lang.Boolean>(this, "admin", "admin", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> lastname = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "lastname", "lastname");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> password = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "password", "password");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> specialization = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "specialization", "specialization");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> token = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "token", "token");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.util.Date> updatedAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.util.Date>(this, "updatedAt", "updatedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> username = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "username", "username");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final DoctorModelMeta slim3_singleton = new DoctorModelMeta();

    /**
     * @return the singleton
     */
    public static DoctorModelMeta get() {
       return slim3_singleton;
    }

    /** */
    public DoctorModelMeta() {
        super("DoctorModel", sample.model.DoctorModel.class);
    }

    @Override
    public sample.model.DoctorModel entityToModel(com.google.appengine.api.datastore.Entity entity) {
        sample.model.DoctorModel model = new sample.model.DoctorModel();
        model.setAddress((java.lang.String) entity.getProperty("address"));
        model.setBirthday((java.util.Date) entity.getProperty("birthday"));
        model.setContactNo((java.lang.String) entity.getProperty("contactNo"));
        model.setCreatedAt((java.util.Date) entity.getProperty("createdAt"));
        model.setDeletedAt((java.util.Date) entity.getProperty("deletedAt"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setFirstname((java.lang.String) entity.getProperty("firstname"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setAdmin(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("admin")));
        model.setKey(entity.getKey());
        model.setLastname((java.lang.String) entity.getProperty("lastname"));
        model.setPassword((java.lang.String) entity.getProperty("password"));
        model.setSpecialization((java.lang.String) entity.getProperty("specialization"));
        model.setToken((java.lang.String) entity.getProperty("token"));
        model.setUpdatedAt((java.util.Date) entity.getProperty("updatedAt"));
        model.setUsername((java.lang.String) entity.getProperty("username"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        sample.model.DoctorModel m = (sample.model.DoctorModel) model;
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
        entity.setProperty("email", m.getEmail());
        entity.setProperty("firstname", m.getFirstname());
        entity.setProperty("id", m.getId());
        entity.setProperty("admin", m.isAdmin());
        entity.setProperty("lastname", m.getLastname());
        entity.setProperty("password", m.getPassword());
        entity.setProperty("specialization", m.getSpecialization());
        entity.setProperty("token", m.getToken());
        entity.setProperty("updatedAt", m.getUpdatedAt());
        entity.setProperty("username", m.getUsername());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        sample.model.DoctorModel m = (sample.model.DoctorModel) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        sample.model.DoctorModel m = (sample.model.DoctorModel) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        sample.model.DoctorModel m = (sample.model.DoctorModel) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        sample.model.DoctorModel m = (sample.model.DoctorModel) model;
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
        sample.model.DoctorModel m = (sample.model.DoctorModel) model;
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
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getFirstname() != null){
            writer.setNextPropertyName("firstname");
            encoder0.encode(writer, m.getFirstname());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        writer.setNextPropertyName("admin");
        encoder0.encode(writer, m.isAdmin());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastname() != null){
            writer.setNextPropertyName("lastname");
            encoder0.encode(writer, m.getLastname());
        }
        if(m.getPassword() != null){
            writer.setNextPropertyName("password");
            encoder0.encode(writer, m.getPassword());
        }
        if(m.getSpecialization() != null){
            writer.setNextPropertyName("specialization");
            encoder0.encode(writer, m.getSpecialization());
        }
        if(m.getToken() != null){
            writer.setNextPropertyName("token");
            encoder0.encode(writer, m.getToken());
        }
        if(m.getUpdatedAt() != null){
            writer.setNextPropertyName("updatedAt");
            encoder0.encode(writer, m.getUpdatedAt());
        }
        if(m.getUsername() != null){
            writer.setNextPropertyName("username");
            encoder0.encode(writer, m.getUsername());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected sample.model.DoctorModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        sample.model.DoctorModel m = new sample.model.DoctorModel();
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
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("firstname");
        m.setFirstname(decoder0.decode(reader, m.getFirstname()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("admin");
        m.setAdmin(decoder0.decode(reader, m.isAdmin()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastname");
        m.setLastname(decoder0.decode(reader, m.getLastname()));
        reader = rootReader.newObjectReader("password");
        m.setPassword(decoder0.decode(reader, m.getPassword()));
        reader = rootReader.newObjectReader("specialization");
        m.setSpecialization(decoder0.decode(reader, m.getSpecialization()));
        reader = rootReader.newObjectReader("token");
        m.setToken(decoder0.decode(reader, m.getToken()));
        reader = rootReader.newObjectReader("updatedAt");
        m.setUpdatedAt(decoder0.decode(reader, m.getUpdatedAt()));
        reader = rootReader.newObjectReader("username");
        m.setUsername(decoder0.decode(reader, m.getUsername()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}