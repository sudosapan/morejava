import com.google.protobuf.InvalidProtocolBufferException;
import com.sapan.java.protobuf.AddressBookProtos;

import static com.sapan.java.protobuf.AddressBookProtos.Person.parseFrom;

public class ProtBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBookProtos.Person john = AddressBookProtos.Person.newBuilder().setId(1).setName("John").addPhones(AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("12355").setType(AddressBookProtos.Person.PhoneType.MOBILE).build()).build();
        System.out.println(john.isInitialized());
        System.out.println(john);

        System.out.println(parseFrom(john.toByteArray()));

    }
}
