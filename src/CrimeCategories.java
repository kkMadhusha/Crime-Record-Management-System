class CrimeCategories {
    private int categoryID;
    private String categoryName;
    private String description;

    public CrimeCategories(int categoryID, String categoryName, String description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
    }

    // Getters and setters
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Method to view category details
    public void viewCategoryDetails() {
        System.out.println("Category ID: " + categoryID);
        System.out.println("Category Name: " + categoryName);
        System.out.println("Description: " + description);
    }
}
