package sample.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-20 17:33:09")
/** */
public final class DiseaseModelMeta extends org.slim3.datastore.ModelMeta<sample.model.DiseaseModel> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, java.util.Date> deletedAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, java.util.Date>(this, "deletedAt", "deletedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<sample.model.DiseaseModel, java.util.List<java.lang.Long>, java.lang.Long> medicineId = new org.slim3.datastore.CollectionAttributeMeta<sample.model.DiseaseModel, java.util.List<java.lang.Long>, java.lang.Long>(this, "medicineId", "medicineId", java.util.List.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.DiseaseModel> name = new org.slim3.datastore.StringAttributeMeta<sample.model.DiseaseModel>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CollectionAttributeMeta<sample.model.DiseaseModel, java.util.List<java.lang.Long>, java.lang.Long> symptomId = new org.slim3.datastore.CollectionAttributeMeta<sample.model.DiseaseModel, java.util.List<java.lang.Long>, java.lang.Long>(this, "symptomId", "symptomId", java.util.List.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, java.util.Date> updatedAt = new org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, java.util.Date>(this, "updatedAt", "updatedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<sample.model.DiseaseModel, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final DiseaseModelMeta slim3_singleton = new DiseaseModelMeta();

    /**
     * @return the singleton
     */
    public static DiseaseModelMeta get() {
       return slim3_singleton;
    }

    /** */
    public DiseaseModelMeta() {
        super("DiseaseModel", sample.model.DiseaseModel.class);
    }

    @Override
    public sample.model.DiseaseModel entityToModel(com.google.appengine.api.datastore.Entity entity) {
        sample.model.DiseaseModel model = new sample.model.DiseaseModel();
        model.setDeletedAt((java.util.Date) entity.getProperty("deletedAt"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setMedicineId(toList(java.lang.Long.class, entity.getProperty("medicineId")));
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setSymptomId(toList(java.lang.Long.class, entity.getProperty("symptomId")));
        model.setUpdatedAt((java.util.Date) entity.getProperty("updatedAt"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        sample.model.DiseaseModel m = (sample.model.DiseaseModel) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("deletedAt", m.getDeletedAt());
        entity.setProperty("id", m.getId());
        entity.setProperty("medicineId", m.getMedicineId());
        entity.setProperty("name", m.getName());
        entity.setProperty("symptomId", m.getSymptomId());
        entity.setProperty("updatedAt", m.getUpdatedAt());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        sample.model.DiseaseModel m = (sample.model.DiseaseModel) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        sample.model.DiseaseModel m = (sample.model.DiseaseModel) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        sample.model.DiseaseModel m = (sample.model.DiseaseModel) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        sample.model.DiseaseModel m = (sample.model.DiseaseModel) model;
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
        sample.model.DiseaseModel m = (sample.model.DiseaseModel) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getDeletedAt() != null){
            writer.setNextPropertyName("deletedAt");
            encoder0.encode(writer, m.getDeletedAt());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getMedicineId() != null){
            writer.setNextPropertyName("medicineId");
            writer.beginArray();
            for(java.lang.Long v : m.getMedicineId()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getSymptomId() != null){
            writer.setNextPropertyName("symptomId");
            writer.beginArray();
            for(java.lang.Long v : m.getSymptomId()){
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
    protected sample.model.DiseaseModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        sample.model.DiseaseModel m = new sample.model.DiseaseModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("deletedAt");
        m.setDeletedAt(decoder0.decode(reader, m.getDeletedAt()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("medicineId");
        {
            java.util.ArrayList<java.lang.Long> elements = new java.util.ArrayList<java.lang.Long>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("medicineId");
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
                m.setMedicineId(elements);
            }
        }
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("symptomId");
        {
            java.util.ArrayList<java.lang.Long> elements = new java.util.ArrayList<java.lang.Long>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("symptomId");
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
                m.setSymptomId(elements);
            }
        }
        reader = rootReader.newObjectReader("updatedAt");
        m.setUpdatedAt(decoder0.decode(reader, m.getUpdatedAt()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}