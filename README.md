# gRPC Client

Consume resources via Rest Template http://localhost:8081/client/product

Consume resources via gRPC http://localhost:8082/server/grpc/product


# What is gRPC?

gRPC (Google Remote Procedure Call)
open-source RPC architecture,gRPC creates high-speed communication between microservices. It was originally developed by Google to improve communications.
allows multiple functions created in different programming languages to work together, thanks to the API. 
gRPC uses the Protobuf (protocol buffers) messaging format, which is a highly packed, highly efficient messaging format for serializing structured data. 
For a specific set of use cases, a gRPC API serves as a more efficient alternative to a REST API

# Why gRPC?
gRPC as a cross-language that makes web services flexible and scalable

gRPC uses a different format. Rather than use JSON, the API uses Protobuf. Protobuf was also developed by Google and is language neutral and platform neutral.
It’s similar to XML, but considered to be more efficient. 

gRPC structure uses HTTP2, instead of the original HTTP1 and is considerably faster than the original RPC.
This means it is easier to implement since it can transmit messages up to 10 times faster than previous versions.

# when gRPC?

Multi-language systems: gRPC is excellent when managing connections within a multilingual environment

Real-time streaming: When real-time communication is a requirement, gRPC’s ability to manage bidirectional streaming allows your system to send and receive messages in real-time without waiting for Unary client-response communication. 
Practise

Low-power, low-bandwidth networks: gRPC’s use of serialized Protobuf messages offers lightweight messaging, greater efficiency, and speed for bandwidth-constrained, low-power networks (especially when compared to JSON).

Microservices connections: gRPC supports high-speed throughput communication, allowing you to connect the architectures that consist of lightweight microservices where the message transmission efficiency is paramount. 

# Disadvantages 

Despite the benefits in message transmission speed, this type of API implementation is much slower than REST API implementation.
gRPC need new learning (learning curve) 
gRPC requires specific software on both the client and server side. gRPC generated code merged into client and server processes
 
 
# Protocol Buffers Structure
https://developers.google.com/protocol-buffers/docs/proto3

