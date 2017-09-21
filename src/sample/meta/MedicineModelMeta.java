package sample.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-09-21 12:13:14")
/** */
public final class MedicineModelMeta extends org.slim3.datastore.ModelMeta<sample.model.MedicineModel> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel> createdAt = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel>(this, "createdAt", "createdAt");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel> deletedAt = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel>(this, "deletedAt", "deletedAt");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel> description = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicineModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicineModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicineModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicineModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel> name = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicineModel, java.lang.Double> price = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicineModel, java.lang.Double>(this, "price", "price", java.lang.Double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel> updatedAt = new org.slim3.datastore.StringAttributeMeta<sample.model.MedicineModel>(this, "updatedAt", "updatedAt");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.MedicineModel, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<sample.model.MedicineModel, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final MedicineModelMeta slim3_singleton = new MedicineModelMeta();

    /**
     * @return the singleton
     */
    public static MedicineModelMeta get() {
       return slim3_singleton;
    }

    /** */
    public MedicineModelMeta() {
        super("MedicineModel", sample.model.MedicineModel.class);
    }

    @Override
    public sample.model.MedicineModel entityToModel(com.google.appengine.api.datastore.Entity entity) {
        sample.model.MedicineModel model = new sample.model.MedicineModel();
        model.setCreatedAt((java.lang.String) entity.getProperty("createdAt"));
        model.setDeletedAt((java.lang.String) entity.getProperty("deletedAt"));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPrice((java.lang.Double) entity.getProperty("price"));
        model.setUpdatedAt((java.lang.String) entity.getProperty("updatedAt"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        sample.model.MedicineModel m = (sample.model.MedicineModel) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createdAt", m.getCreatedAt());
        entity.setProperty("deletedAt", m.getDeletedAt());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("id", m.getId());
        entity.setProperty("name", m.getName());
        entity.setProperty("price", m.getPrice());
        entity.setProperty("updatedAt", m.getUpdatedAt());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        sample.model.MedicineModel m = (sample.model.MedicineModel) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        sample.model.MedicineModel m = (sample.model.MedicineModel) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        sample.model.MedicineModel m = (sample.model.MedicineModel) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        sample.model.MedicineModel m = (sample.model.MedicineModel) model;
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
        sample.model.MedicineModel m = (sample.model.MedicineModel) model;
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
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getPrice() != null){
            writer.setNextPropertyName("price");
            encoder0.encode(writer, m.getPrice());
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
    protected sample.model.MedicineModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        sample.model.MedicineModel m = new sample.model.MedicineModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createdAt");
        m.setCreatedAt(decoder0.decode(reader, m.getCreatedAt()));
        reader = rootReader.newObjectReader("deletedAt");
        m.setDeletedAt(decoder0.decode(reader, m.getDeletedAt()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("price");
        m.setPrice(decoder0.decode(reader, m.getPrice()));
        reader = rootReader.newObjectReader("updatedAt");
        m.setUpdatedAt(decoder0.decode(reader, m.getUpdatedAt()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}