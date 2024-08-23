package br.com.syonet.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import br.com.syonet.FileReaderExemple;

public class NIOFileReaderExemple extends FileReaderExemple  {
    public NIOFileReaderExemple(String filePath) {
        super(filePath);
      }
      
      public void execute() {
          try (
            RandomAccessFile file = new RandomAccessFile(this.filePath, "r");
            FileChannel channel = file.getChannel();
          ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = channel.read(buffer);
            while (bytesRead != -1) {
              buffer.flip();
              while (buffer.hasRemaining()) {
                //System.out.print((char) buffer.get());

              }
              //System.out.println();
              buffer.clear();
              bytesRead = channel.read(buffer);
            }
          } catch (IOException e) {
            e.printStackTrace();
          }
      }
}
