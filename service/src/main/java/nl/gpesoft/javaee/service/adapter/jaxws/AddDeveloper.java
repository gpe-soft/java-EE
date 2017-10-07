
package nl.gpesoft.javaee.service.adapter.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import nl.gpesoft.javaee.domain.entity.Developer;

@XmlRootElement(name = "addDeveloper", namespace = "http://adapter.service.javaee.gpesoft.nl/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addDeveloper", namespace = "http://adapter.service.javaee.gpesoft.nl/")
public class AddDeveloper {

    @XmlElement(name = "arg0", namespace = "")
    private Developer arg0;

    /**
     * 
     * @return
     *     returns Developer
     */
    public Developer getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(Developer arg0) {
        this.arg0 = arg0;
    }

}
