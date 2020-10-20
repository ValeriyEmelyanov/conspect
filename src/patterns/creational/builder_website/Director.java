package patterns.creational.builder_website;

public class Director {
    private WebsiteBuilder builder;

    public void setBuilder(WebsiteBuilder builder) {
        this.builder = builder;
    }

    public Website buildWebsite() {
        builder.createWebsite();
        builder.buildName();
        builder.buildCms();
        builder.buildPrice();
        return builder.getWebsite();
    }
}
