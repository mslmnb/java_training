package practice1.apartment.model;

public class BaseEntity {
    private static int idCounter ;
    private Integer id;

    public BaseEntity() {
        this.idCounter ++ ;
        this.id = idCounter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        if (obj==null||!this.getClass().equals(obj.getClass())) {
            return false;
        }
        BaseEntity that = (BaseEntity) obj;
        return (this.getId()!=null && this.getId().equals(that.getId()));
    }

    @Override
    public int hashCode() {
        return this.getId()==null ? 0 : this.getId() ;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
