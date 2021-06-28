package BioNioAio.NettyImlRPC.Server;

public class StudentSevice implements IStudentSevice{
    @Override
    public String getStudentName(int id) {
        return "Edward" + id;
    }
}
