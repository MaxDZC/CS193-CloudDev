package sample.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-16 16:53:35")
/** */
public final class PatientModelMeta extends org.slim3.datastore.ModelMeta<sample.model.PatientModel> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> address = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "address", "address");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> birthDay = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "birthDay", "birthDay");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> contactNumber = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "contactNumber", "contactNumber");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> createdaAt = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "createdaAt", "createdaAt");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> deletedAt = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "deletedAt", "deletedAt");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> firstName = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "firstName", "firstName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.PatientModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> lastName = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "lastName", "lastName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> passWord = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "passWord", "passWord");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> specialization = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "specialization", "specialization");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> updatedAt = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "updatedAt", "updatedAt");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel> userName = new org.slim3.datastore.StringAttributeMeta<sample.model.PatientModel>(this, "userName", "userName");

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
        model.setBirthDay((java.lang.String) entity.getProperty("birthDay"));
        model.setContactNumber((java.lang.String) entity.getProperty("contactNumber"));
        model.setCreatedaAt((java.lang.String) entity.getProperty("createdaAt"));
        model.setDeletedAt((java.lang.String) entity.getProperty("deletedAt"));
        model.setFirstName((java.lang.String) entity.getProperty("firstName"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setLastName((java.lang.String) entity.getProperty("lastName"));
        model.setPassWord((java.lang.String) entity.getProperty("passWord"));
        model.setSpecialization((java.lang.String) entity.getProperty("specialization"));
        model.setUpdatedAt((java.lang.String) entity.getProperty("updatedAt"));
        model.setUserName((java.lang.String) entity.getProperty("userName"));
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
        entity.setProperty("birthDay", m.getBirthDay());
        entity.setProperty("contactNumber", m.getContactNumber());
        entity.setProperty("createdaAt", m.getCreatedaAt());
        entity.setProperty("deletedAt", m.getDeletedAt());
        entity.setProperty("firstName", m.getFirstName());
        entity.setProperty("id", m.getId());
        entity.setProperty("lastName", m.getLastName());
        entity.setProperty("passWord", m.getPassWord());
        entity.setProperty("specialization", m.getSpecialization());
        entity.setProperty("updatedAt", m.getUpdatedAt());
        entity.setProperty("userName", m.getUserName());
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
        if(m.getBirthDay() != null){
            writer.setNextPropertyName("birthDay");
            encoder0.encode(writer, m.getBirthDay());
        }
        if(m.getContactNumber() != null){
            writer.setNextPropertyName("contactNumber");
            encoder0.encode(writer, m.getContactNumber());
        }
        if(m.getCreatedaAt() != null){
            writer.setNextPropertyName("createdaAt");
            encoder0.encode(writer, m.getCreatedaAt());
        }
        if(m.getDeletedAt() != null){
            writer.setNextPropertyName("deletedAt");
            encoder0.encode(writer, m.getDeletedAt());
        }
        if(m.getFirstName() != null){
            writer.setNextPropertyName("firstName");
            encoder0.encode(writer, m.getFirstName());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastName() != null){
            writer.setNextPropertyName("lastName");
            encoder0.encode(writer, m.getLastName());
        }
        if(m.getPassWord() != null){
            writer.setNextPropertyName("passWord");
            encoder0.encode(writer, m.getPassWord());
        }
        if(m.getSpecialization() != null){
            writer.setNextPropertyName("specialization");
            encoder0.encode(writer, m.getSpecialization());
        }
        if(m.getUpdatedAt() != null){
            writer.setNextPropertyName("updatedAt");
            encoder0.encode(writer, m.getUpdatedAt());
        }
        if(m.getUserName() != null){
            writer.setNextPropertyName("userName");
            encoder0.encode(writer, m.getUserName());
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
        reader = rootReader.newObjectReader("birthDay");
        m.setBirthDay(decoder0.decode(reader, m.getBirthDay()));
        reader = rootReader.newObjectReader("contactNumber");
        m.setContactNumber(decoder0.decode(reader, m.getContactNumber()));
        reader = rootReader.newObjectReader("createdaAt");
        m.setCreatedaAt(decoder0.decode(reader, m.getCreatedaAt()));
        reader = rootReader.newObjectReader("deletedAt");
        m.setDeletedAt(decoder0.decode(reader, m.getDeletedAt()));
        reader = rootReader.newObjectReader("firstName");
        m.setFirstName(decoder0.decode(reader, m.getFirstName()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastName");
        m.setLastName(decoder0.decode(reader, m.getLastName()));
        reader = rootReader.newObjectReader("passWord");
        m.setPassWord(decoder0.decode(reader, m.getPassWord()));
        reader = rootReader.newObjectReader("specialization");
        m.setSpecialization(decoder0.decode(reader, m.getSpecialization()));
        reader = rootReader.newObjectReader("updatedAt");
        m.setUpdatedAt(decoder0.decode(reader, m.getUpdatedAt()));
        reader = rootReader.newObjectReader("userName");
        m.setUserName(decoder0.decode(reader, m.getUserName()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}