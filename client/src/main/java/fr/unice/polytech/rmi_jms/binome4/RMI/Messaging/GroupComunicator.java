package fr.unice.polytech.rmi_jms.binome4.RMI.Messaging;
import javax.jms.*;
import fr.unice.polytech.rmi_jms.binome4.RMI.IGroup;
import fr.unice.polytech.rmi_jms.binome4.RMI.IUser;
import org.apache.activemq.command.ActiveMQObjectMessage;

import java.rmi.RemoteException;
import java.security.acl.Group;

public class GroupComunicator {
    private IGroup group;
    private IUser user;
    private Session rsession;
    private MessageConsumer rqueue;
    private String receiveName;
    private MessageProducer publisher;


    public GroupComunicator(IGroup group, IUser user, Connection connection) throws JMSException, RemoteException {
        this.group = group;
        this.user= user;
        this.rsession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


    }

    private void receiveMessage(Message message) {

        ObjectMessage oMessage = (ObjectMessage) message;
        try {
            GroupMessage groupMessage = (GroupMessage)oMessage.getObject();
            System.out.println(groupMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public void subscribe() throws JMSException, RemoteException {
        final Topic topic = rsession.createTopic(group.getName());
        this.rqueue = rsession.createDurableSubscriber(topic,user.getName());
        this.rqueue.setMessageListener(this::receiveMessage);
        this.publisher = rsession.createProducer(topic);
    }

    public void sendMessage(String payload) {
        GroupMessage groupMessage = new GroupMessage(payload,user);
        ObjectMessage objectMessage = new ActiveMQObjectMessage();
        try {
            objectMessage.setObject(groupMessage);
            this.publisher.send(objectMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
