
package nl.gpesoft.javaee.service.adapter.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import nl.gpesoft.javaee.domain.entity.Developer;

@XmlRootElement(name = "getDevelopersResponse", namespace = "http://adapter.service.javaee.gpesoft.nl/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDevelopersResponse", namespace = "http://adapter.service.javaee.gpesoft.nl/")
public class GetDevelopersResponse {

    @XmlElement(name = "return", namespace = "")
    private List<Developer> _return;

    /**
     * 
     * @return
     *     returns List<Developer>
     */
    public List<Developer> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<Developer> _return) {
        this._return = _return;
    }

}
