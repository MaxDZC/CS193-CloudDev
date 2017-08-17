package sample.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-08-17 19:01:54")
/** */
public final class TweetMeta extends org.slim3.datastore.ModelMeta<sample.model.Tweet> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.Tweet> content = new org.slim3.datastore.StringAttributeMeta<sample.model.Tweet>(this, "content", "content");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<sample.model.Tweet> createdDate = new org.slim3.datastore.StringAttributeMeta<sample.model.Tweet>(this, "createdDate", "createdDate");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.Tweet, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<sample.model.Tweet, java.lang.Long>(this, "id", "id", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.Tweet, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<sample.model.Tweet, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<sample.model.Tweet, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<sample.model.Tweet, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TweetMeta slim3_singleton = new TweetMeta();

    /**
     * @return the singleton
     */
    public static TweetMeta get() {
       return slim3_singleton;
    }

    /** */
    public TweetMeta() {
        super("Tweet", sample.model.Tweet.class);
    }

    @Override
    public sample.model.Tweet entityToModel(com.google.appengine.api.datastore.Entity entity) {
        sample.model.Tweet model = new sample.model.Tweet();
        model.setContent((java.lang.String) entity.getProperty("content"));
        model.setCreatedDate((java.lang.String) entity.getProperty("createdDate"));
        model.setId(longToPrimitiveLong((java.lang.Long) entity.getProperty("id")));
        model.setKey(entity.getKey());
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        sample.model.Tweet m = (sample.model.Tweet) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("content", m.getContent());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("id", m.getId());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        sample.model.Tweet m = (sample.model.Tweet) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        sample.model.Tweet m = (sample.model.Tweet) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        sample.model.Tweet m = (sample.model.Tweet) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        sample.model.Tweet m = (sample.model.Tweet) model;
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
        sample.model.Tweet m = (sample.model.Tweet) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getContent() != null){
            writer.setNextPropertyName("content");
            encoder0.encode(writer, m.getContent());
        }
        if(m.getCreatedDate() != null){
            writer.setNextPropertyName("createdDate");
            encoder0.encode(writer, m.getCreatedDate());
        }
        writer.setNextPropertyName("id");
        encoder0.encode(writer, m.getId());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected sample.model.Tweet jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        sample.model.Tweet m = new sample.model.Tweet();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("content");
        m.setContent(decoder0.decode(reader, m.getContent()));
        reader = rootReader.newObjectReader("createdDate");
        m.setCreatedDate(decoder0.decode(reader, m.getCreatedDate()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}