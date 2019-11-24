/*
 * Copyright 2019 Fusionlab, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.fusiondb.kvstore;

import com.apple.foundationdb.*;
import com.apple.foundationdb.async.AsyncIterable;
import com.apple.foundationdb.directory.DirectoryLayer;
import com.apple.foundationdb.directory.DirectorySubspace;
import com.apple.foundationdb.tuple.Tuple;

import java.util.ArrayList;
import java.util.List;

public class FDBTest {
    public static void main(String[] args) {
        FDB fdb = FDB.selectAPIVersion(610);
        final DirectoryLayer dir = new DirectoryLayer();

        try(Database db = fdb.open()) {
            // InsertRow(db);
            directorySubspaceRow(dir, db);
            // getAllByRange(db);
            // keySelect(db);

        } catch (FDBException exception) {
            exception.printStackTrace();
        }
    }

    private static void keySelect(Database db) {
        db.run(tr -> {
            long version = tr.getReadVersion().join();
            System.out.println("DB version: " + version);
            byte[] val = tr.get("hello".getBytes()).join();
            System.out.println("Value is " +
                    (val != null ? new String(val) : "not present"));
            AsyncIterable<KeyValue> entryList = tr.getRange(
                    KeySelector.firstGreaterOrEqual(Tuple.from("1").pack()),
                    KeySelector.firstGreaterOrEqual(Tuple.from("9").pack()));
            List<KeyValue> entries = entryList.asList().join();

            System.out.println("List size is " + entries.size());
            for(int i=0; i < entries.size(); i++) {
                String key = new String(entries.get(i).getKey());
                String value = new String(entries.get(i).getValue());
                System.out.println(" (" + i + ") -> " + key + ", " + value);
            }
            System.out.println("\nAlso:");
            for(KeyValue kv : entryList) {
                String key = new String(kv.getKey());
                String value = new String(kv.getValue());
                System.out.println(" -- " + key + " -> " + value);
            }

            // tr.clear(new byte[0], new byte[]{(byte)0xff}); // Clear user space.
            return null;
        });
    }

    private static void directorySubspaceRow(DirectoryLayer directoryLayer, Database db) {
//        strSplit(directoryLayer, db);
        db.run(tr -> {
            List<String> path = new ArrayList<>();
            path.add("sql");
            path.add("data");
            path.add("table");
            path.add("schema_a");
            path.add("table_name_1");
            DirectorySubspace dir = directoryLayer.createOrOpen(tr, path).join();
            System.out.println(new String(dir.pack("ShardID_RowID/PrimaryKey/UniqueID: Value")));
            System.out.println(new String(dir.pack("ShardID_IndexColumnName_IndexID_ColumnsValue /or _RowID: null/RowID")));
            tr.set(dir.pack("0001_1_1"), "1, hello，小张".getBytes());
            tr.set(dir.pack("0001_11_11"), "11, hh，小张".getBytes());
            tr.set(dir.pack("0001_12_12"), "12, ss，小s".getBytes());
            tr.set(dir.pack("0001_13_13"), "13, tt，小t".getBytes());
            tr.set(dir.pack("0002_2_2"), "2, world，小李".getBytes());
            tr.set(dir.pack("0030_3_3"), "3, hua，小化".getBytes());
            tr.set(dir.pack("0999_3_10"), "10, bai，小白".getBytes());
            tr.set(dir.pack("1000_4_4"), "4, zhou，小周".getBytes());
            tr.set(dir.pack("1002_5_5"), "5, ma，小马".getBytes());
            tr.set(dir.pack("1999_6_6"), "6, gu，小谷".getBytes());
            tr.set(dir.pack("2000_7_6"), "7, wu，小吴".getBytes());
            tr.set(dir.pack("2001_8_6"), "8, ting，小停".getBytes());
            tr.set(dir.pack("2100_9_6"), "9, wang，小王".getBytes());
            tr.set(dir.pack("2999_10_6"), "10, feng，小冯".getBytes());
//            System.out.println(new String(tr.get(dir.pack("0001_1_1")).join()));

            Range r1 = new Range(dir.pack("0001_"), dir.pack("0002_"));
            Range r2 = new Range(dir.pack("1000_"), dir.pack("2000_"));
            Range r3 = new Range(dir.pack("2000_1"), dir.pack("2999_9"));

            tr.getRange(r1).forEach(line -> {
                String key = new String(line.getKey());
                String value = new String(line.getValue());
                System.out.println(key + ":" + value);
                // Clear user space.
                // tr.clear(new byte[0], new byte[]{(byte)0xff});
            });

            return null;
        });
    }

    private static void strSplit(DirectoryLayer directoryLayer, Database db) {
        db.run(tr -> {
            List<String> path = new ArrayList<>();
            path.add("sql");
            path.add("data");
            path.add("table");
            path.add("schema_a");
            path.add("table_name_1");
            DirectorySubspace dir = directoryLayer.createOrOpen(tr, path).join();
            System.out.println(new String(dir.pack("ShardID_RowID/PrimaryKey/uniqueID: Value")));
            System.out.println(new String(dir.pack("ShardID_IndexColumnName_IndexID_ColumnsValue /or _RowID: null/RowID")));
            tr.set(dir.pack("s1_1_1"), "1, hello，小张".getBytes());
            tr.set(dir.pack("s1_2_2"), "2, world，小李".getBytes());
            tr.set(dir.pack("s1_3_3"), "3, hua，小化".getBytes());
            tr.set(dir.pack("s1_3_10"), "10, bai，小白".getBytes());
            tr.set(dir.pack("s2_4_4"), "4, zhou，小周".getBytes());
            tr.set(dir.pack("s3_5_5"), "5, ma，小马".getBytes());
            tr.set(dir.pack("s3_6_6"), "6, xu，小徐".getBytes());
            System.out.println(new String(tr.get(dir.pack("s1_1_1")).join()));

            Range r1 = new Range(dir.pack("s1_1"), dir.pack("s1_9"));
            Range r2 = new Range(dir.pack("s2_1"), dir.pack("s2_9"));
            Range r3 = new Range(dir.pack("s3_1"), dir.pack("s3_9"));

            tr.getRange(r1).forEach(line -> {
                String key = new String(line.getKey());
                String value = new String(line.getValue());
                System.out.println(key + ":" + value);
                // Clear user space.
                // transaction.clear(new byte[0], new byte[]{(byte)0xff});
            });

            return null;
        });
    }

    private static void getAllByRange(Database db) {
        db.run(transaction -> {
            Range range = new Range(new byte[0], new byte[]{(byte)0xff});
            transaction.getRange(range).forEach(line -> {
                String key = Tuple.fromBytes(line.getKey()).get(0).toString();
                String value = Tuple.fromBytes(line.getValue()).get(0).toString();
                System.out.println(key + ":" + value);

                // Clear user space.
                // transaction.clear(new byte[0], new byte[]{(byte)0xff});
            });
            return null;
        });
    }

    private static void InsertRow(Database db) {
        // Run an operation on the database
        db.run(transaction -> {
            transaction.set(Tuple.from("1").pack(), Tuple.from("1, hadoop").pack());
            transaction.set(Tuple.from("2").pack(), Tuple.from("2, spark").pack());
            transaction.set(Tuple.from("3").pack(), Tuple.from("3, impala").pack());
            transaction.set(Tuple.from("4").pack(), Tuple.from("4, Oracle").pack());
            transaction.set(Tuple.from("5").pack(), Tuple.from("5, 范式").pack());
            transaction.set(Tuple.from("6").pack(), Tuple.from("6, 百度").pack());
            transaction.set(Tuple.from("30").pack(), Tuple.from("7, 阿里").pack());
            return null;
        });

        String hello = db.run(transaction -> {
            byte[] result = transaction.get(Tuple.from("1").pack()).join();
            return Tuple.fromBytes(result).getString(0);
        });
        System.out.println(hello);
    }
}
