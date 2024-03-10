import socket

serverIP = "127.0.0.1"
serverPort = 9008
msg_value = 300
msg_bytes = msg_value.to_bytes(4, byteorder='little')
# msg = "Ping Python Udp!"
msg = "żółta gęś"

print('PYTHON UDP CLIENT')
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
client.sendto(msg.encode('UTF-8'), (serverIP, serverPort))
# client.sendto(bytes(msg, 'cp1250'), (serverIP, serverPort))

client.sendto(msg_bytes, (serverIP, serverPort))

bufferSize = 1024
response, _ = client.recvfrom(bufferSize)
print("Received message from server: " + response.decode('UTF-8'))


bufferSize = 1024
response, _ = client.recvfrom(bufferSize)
received_value = int.from_bytes(response, byteorder='little')
print(f"Received incremented value from server: {received_value}")



