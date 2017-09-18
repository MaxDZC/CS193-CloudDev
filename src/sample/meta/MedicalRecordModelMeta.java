package sample.meta;

<<<<<<< HEAD
//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-18 00:49:49")
=======
//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-18 12:02:11")
>>>>>>> 85bcb86510cd863e2ae63da9b0808e1c9865a6fe
/** */
public final class MedicalRecordModelMeta extends org.slim3.datastore.ModelMeta<sample.model.MedicalRecordModel> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel> admissionDate = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel>(this, "admissionDate", "admissionDate");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel> birthDay = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel>(this, "birthDay", "birthDay");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel> deletedAt = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel>(this, "deletedAt", "deletedAt");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel> disease = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel>(this, "disease", "disease");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel> firstName = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel>(this, "firstName", "firstName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel> lastName = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel>(this, "lastName", "lastName");

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Integer>, java.lang.Integer> medicines = new org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Integer>, java.lang.Integer>(this, "medicines", "medicines", java.util.ArrayList.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel> sex = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicalRecordModel>(this, "sex", "sex");

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Integer>, java.lang.Integer> symptoms = new org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Integer>, java.lang.Integer>(this, "symptoms", "symptoms", java.util.ArrayList.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final MedicalRecordModelMeta slim3_singleton = new MedicalRecordModelMeta();

    /**
     * @return the singleton
     */
    public static MedicalRecordModelMeta get() {
       return slim3_singleton;
    }

    /** */
    public MedicalRecordModelMeta() {
        super("MedicalRecordModel", sample.model.MedicalRecordModel.class);
    }

    @Override
    public sample.model.MedicalRecordModel entityToModel(com.google.appengine.api.datastore.Entity entity) {
        sample.model.MedicalRecordModel model = new sample.model.MedicalRecordModel();
        model.setAdmissionDate((java.lang.String) entity.getProperty("admissionDate"));
        model.setBirthDay((java.lang.String) entity.getProperty("birthDay"));
        model.setDeletedAt((java.lang.String) entity.getProperty("deletedAt"));
        model.setDisease((java.lang.String) entity.getProperty("disease"));
        model.setFirstName((java.lang.String) entity.getProperty("firstName"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setLastName((java.lang.String) entity.getProperty("lastName"));
        model.setMedicines(longListToIntegerList(entity.getProperty("medicines")));
        model.setSex((java.lang.String) entity.getProperty("sex"));
        model.setSymptoms(longListToIntegerList(entity.getProperty("symptoms")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        sample.model.MedicalRecordModel m = (sample.model.MedicalRecordModel) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("admissionDate", m.getAdmissionDate());
        entity.setProperty("birthDay", m.getBirthDay());
        entity.setProperty("deletedAt", m.getDeletedAt());
        entity.setProperty("disease", m.getDisease());
        entity.setProperty("firstName", m.getFirstName());
        entity.setProperty("id", m.getId());
        entity.setProperty("lastName", m.getLastName());
        entity.setProperty("medicines", m.getMedicines());
        entity.setProperty("sex", m.getSex());
        entity.setProperty("symptoms", m.getSymptoms());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        sample.model.MedicalRecordModel m = (sample.model.MedicalRecordModel) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        sample.model.MedicalRecordModel m = (sample.model.MedicalRecordModel) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        sample.model.MedicalRecordModel m = (sample.model.MedicalRecordModel) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        sample.model.MedicalRecordModel m = (sample.model.MedicalRecordModel) model;
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
        sample.model.MedicalRecordModel m = (sample.model.MedicalRecordModel) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAdmissionDate() != null){
            writer.setNextPropertyName("admissionDate");
            encoder0.encode(writer, m.getAdmissionDate());
        }
        if(m.getBirthDay() != null){
            writer.setNextPropertyName("birthDay");
            encoder0.encode(writer, m.getBirthDay());
        }
        if(m.getDeletedAt() != null){
            writer.setNextPropertyName("deletedAt");
            encoder0.encode(writer, m.getDeletedAt());
        }
        if(m.getDisease() != null){
            writer.setNextPropertyName("disease");
            encoder0.encode(writer, m.getDisease());
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
        if(m.getMedicines() != null){
            writer.setNextPropertyName("medicines");
            writer.beginArray();
            for(java.lang.Integer v : m.getMedicines()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getSex() != null){
            writer.setNextPropertyName("sex");
            encoder0.encode(writer, m.getSex());
        }
        if(m.getSymptoms() != null){
            writer.setNextPropertyName("symptoms");
            writer.beginArray();
            for(java.lang.Integer v : m.getSymptoms()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected sample.model.MedicalRecordModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        sample.model.MedicalRecordModel m = new sample.model.MedicalRecordModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("admissionDate");
        m.setAdmissionDate(decoder0.decode(reader, m.getAdmissionDate()));
        reader = rootReader.newObjectReader("birthDay");
        m.setBirthDay(decoder0.decode(reader, m.getBirthDay()));
        reader = rootReader.newObjectReader("deletedAt");
        m.setDeletedAt(decoder0.decode(reader, m.getDeletedAt()));
        reader = rootReader.newObjectReader("disease");
        m.setDisease(decoder0.decode(reader, m.getDisease()));
        reader = rootReader.newObjectReader("firstName");
        m.setFirstName(decoder0.decode(reader, m.getFirstName()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastName");
        m.setLastName(decoder0.decode(reader, m.getLastName()));
        reader = rootReader.newObjectReader("medicines");
        {
            java.util.ArrayList<java.lang.Integer> elements = new java.util.ArrayList<java.lang.Integer>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("medicines");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.Integer v = decoder0.decode(reader, (java.lang.Integer)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setMedicines(elements);
            }
        }
        reader = rootReader.newObjectReader("sex");
        m.setSex(decoder0.decode(reader, m.getSex()));
        reader = rootReader.newObjectReader("symptoms");
        {
            java.util.ArrayList<java.lang.Integer> elements = new java.util.ArrayList<java.lang.Integer>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("symptoms");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.Integer v = decoder0.decode(reader, (java.lang.Integer)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setSymptoms(elements);
            }
        }
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}