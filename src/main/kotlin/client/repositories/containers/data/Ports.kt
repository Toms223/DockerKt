package client.repositories.containers.data

data class Ports(val type: PortsType, val port: Int){
    override fun toString(): String {
        return "$port/${type.name.lowercase()}"
    }
}
