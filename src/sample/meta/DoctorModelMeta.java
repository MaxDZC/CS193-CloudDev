package sample.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-08-20 00:52:24")
/** */
public final class DoctorModelMeta extends org.slim3.datastore.ModelMeta<sample.model.DoctorModel> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> address = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "address", "address");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> birthDay = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "birthDay", "birthDay");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> contactNumber = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "contactNumber", "contactNumber");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> email = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> firstName = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "firstName", "firstName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.DoctorModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> lastName = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "lastName", "lastName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> passWord = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "passWord", "passWord");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> specialization = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "specialization", "specialization");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel> userName = new org.slim3.datastore.StringAttributeMeta<sample.model.DoctorModel>(this, "userName", "userName");

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
        model.setBirthDay((java.lang.String) entity.getProperty("birthDay"));
        model.setContactNumber((java.lang.String) entity.getProperty("contactNumber"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setFirstName((java.lang.String) entity.getProperty("firstName"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setLastName((java.lang.String) entity.getProperty("lastName"));
        model.setPassWord((java.lang.String) entity.getProperty("passWord"));
        model.setSpecialization((java.lang.String) entity.getProperty("specialization"));
        model.setUserName((java.lang.String) entity.getProperty("userName"));
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
        entity.setProperty("birthDay", m.getBirthDay());
        entity.setProperty("contactNumber", m.getContactNumber());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("firstName", m.getFirstName());
        entity.setProperty("id", m.getId());
        entity.setProperty("lastName", m.getLastName());
        entity.setProperty("passWord", m.getPassWord());
        entity.setProperty("specialization", m.getSpecialization());
        entity.setProperty("userName", m.getUserName());
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
        if(m.getBirthDay() != null){
            writer.setNextPropertyName("birthDay");
            encoder0.encode(writer, m.getBirthDay());
        }
        if(m.getContactNumber() != null){
            writer.setNextPropertyName("contactNumber");
            encoder0.encode(writer, m.getContactNumber());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
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
    protected sample.model.DoctorModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        sample.model.DoctorModel m = new sample.model.DoctorModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("address");
        m.setAddress(decoder0.decode(reader, m.getAddress()));
        reader = rootReader.newObjectReader("birthDay");
        m.setBirthDay(decoder0.decode(reader, m.getBirthDay()));
        reader = rootReader.newObjectReader("contactNumber");
        m.setContactNumber(decoder0.decode(reader, m.getContactNumber()));
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
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
        reader = rootReader.newObjectReader("userName");
        m.setUserName(decoder0.decode(reader, m.getUserName()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}