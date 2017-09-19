package sample.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-19 15:52:46")
/** */
public final class MedicalRecordModelMeta extends org.slim3.datastore.ModelMeta<sample.model.MedicalRecordModel> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.util.Date> createdAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.util.Date>(this, "createdAt", "createdAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.util.Date> deletedAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.util.Date>(this, "deletedAt", "deletedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.util.Date> dischargeDate = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.util.Date>(this, "dischargeDate", "dischargeDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Long>, java.lang.Long> diseaseIdList = new org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Long>, java.lang.Long>(this, "diseaseIdList", "diseaseIdList", java.util.ArrayList.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long> doctorId = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long>(this, "doctorId", "doctorId", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Boolean> inPatient = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Boolean>(this, "inPatient", "inPatient", java.lang.Boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Long>, java.lang.Long> medicineIdList = new org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Long>, java.lang.Long>(this, "medicineIdList", "medicineIdList", java.util.ArrayList.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long> patientId = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.lang.Long>(this, "patientId", "patientId", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Long>, java.lang.Long> quantityList = new org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Long>, java.lang.Long>(this, "quantityList", "quantityList", java.util.ArrayList.class);

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Long>, java.lang.Long> symptomIdList = new org.slim3.datastore.CollectionAttributeMeta<sample.model.MedicalRecordModel, java.util.ArrayList<java.lang.Long>, java.lang.Long>(this, "symptomIdList", "symptomIdList", java.util.ArrayList.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.util.Date> updatedAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicalRecordModel, java.util.Date>(this, "updatedAt", "updatedAt", java.util.Date.class);

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
        model.setCreatedAt((java.util.Date) entity.getProperty("createdAt"));
        model.setDeletedAt((java.util.Date) entity.getProperty("deletedAt"));
        model.setDischargeDate((java.util.Date) entity.getProperty("dischargeDate"));
        model.setDiseaseIdList(toList(java.lang.Long.class, entity.getProperty("diseaseIdList")));
        model.setDoctorId((java.lang.Long) entity.getProperty("doctorId"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setInPatient((java.lang.Boolean) entity.getProperty("inPatient"));
        model.setKey(entity.getKey());
        model.setMedicineIdList(toList(java.lang.Long.class, entity.getProperty("medicineIdList")));
        model.setPatientId((java.lang.Long) entity.getProperty("patientId"));
        model.setQuantityList(toList(java.lang.Long.class, entity.getProperty("quantityList")));
        model.setSymptomIdList(toList(java.lang.Long.class, entity.getProperty("symptomIdList")));
        model.setUpdatedAt((java.util.Date) entity.getProperty("updatedAt"));
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
        entity.setProperty("createdAt", m.getCreatedAt());
        entity.setProperty("deletedAt", m.getDeletedAt());
        entity.setProperty("dischargeDate", m.getDischargeDate());
        entity.setProperty("diseaseIdList", m.getDiseaseIdList());
        entity.setProperty("doctorId", m.getDoctorId());
        entity.setProperty("id", m.getId());
        entity.setProperty("inPatient", m.getInPatient());
        entity.setProperty("medicineIdList", m.getMedicineIdList());
        entity.setProperty("patientId", m.getPatientId());
        entity.setProperty("quantityList", m.getQuantityList());
        entity.setProperty("symptomIdList", m.getSymptomIdList());
        entity.setProperty("updatedAt", m.getUpdatedAt());
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
        if(m.getCreatedAt() != null){
            writer.setNextPropertyName("createdAt");
            encoder0.encode(writer, m.getCreatedAt());
        }
        if(m.getDeletedAt() != null){
            writer.setNextPropertyName("deletedAt");
            encoder0.encode(writer, m.getDeletedAt());
        }
        if(m.getDischargeDate() != null){
            writer.setNextPropertyName("dischargeDate");
            encoder0.encode(writer, m.getDischargeDate());
        }
        if(m.getDiseaseIdList() != null){
            writer.setNextPropertyName("diseaseIdList");
            writer.beginArray();
            for(java.lang.Long v : m.getDiseaseIdList()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getDoctorId() != null){
            writer.setNextPropertyName("doctorId");
            encoder0.encode(writer, m.getDoctorId());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getInPatient() != null){
            writer.setNextPropertyName("inPatient");
            encoder0.encode(writer, m.getInPatient());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getMedicineIdList() != null){
            writer.setNextPropertyName("medicineIdList");
            writer.beginArray();
            for(java.lang.Long v : m.getMedicineIdList()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getPatientId() != null){
            writer.setNextPropertyName("patientId");
            encoder0.encode(writer, m.getPatientId());
        }
        if(m.getQuantityList() != null){
            writer.setNextPropertyName("quantityList");
            writer.beginArray();
            for(java.lang.Long v : m.getQuantityList()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getSymptomIdList() != null){
            writer.setNextPropertyName("symptomIdList");
            writer.beginArray();
            for(java.lang.Long v : m.getSymptomIdList()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
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
    protected sample.model.MedicalRecordModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        sample.model.MedicalRecordModel m = new sample.model.MedicalRecordModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createdAt");
        m.setCreatedAt(decoder0.decode(reader, m.getCreatedAt()));
        reader = rootReader.newObjectReader("deletedAt");
        m.setDeletedAt(decoder0.decode(reader, m.getDeletedAt()));
        reader = rootReader.newObjectReader("dischargeDate");
        m.setDischargeDate(decoder0.decode(reader, m.getDischargeDate()));
        reader = rootReader.newObjectReader("diseaseIdList");
        {
            java.util.ArrayList<java.lang.Long> elements = new java.util.ArrayList<java.lang.Long>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("diseaseIdList");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.Long v = decoder0.decode(reader, (java.lang.Long)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setDiseaseIdList(elements);
            }
        }
        reader = rootReader.newObjectReader("doctorId");
        m.setDoctorId(decoder0.decode(reader, m.getDoctorId()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("inPatient");
        m.setInPatient(decoder0.decode(reader, m.getInPatient()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("medicineIdList");
        {
            java.util.ArrayList<java.lang.Long> elements = new java.util.ArrayList<java.lang.Long>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("medicineIdList");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.Long v = decoder0.decode(reader, (java.lang.Long)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setMedicineIdList(elements);
            }
        }
        reader = rootReader.newObjectReader("patientId");
        m.setPatientId(decoder0.decode(reader, m.getPatientId()));
        reader = rootReader.newObjectReader("quantityList");
        {
            java.util.ArrayList<java.lang.Long> elements = new java.util.ArrayList<java.lang.Long>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("quantityList");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.Long v = decoder0.decode(reader, (java.lang.Long)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setQuantityList(elements);
            }
        }
        reader = rootReader.newObjectReader("symptomIdList");
        {
            java.util.ArrayList<java.lang.Long> elements = new java.util.ArrayList<java.lang.Long>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("symptomIdList");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.Long v = decoder0.decode(reader, (java.lang.Long)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setSymptomIdList(elements);
            }
        }
        reader = rootReader.newObjectReader("updatedAt");
        m.setUpdatedAt(decoder0.decode(reader, m.getUpdatedAt()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}