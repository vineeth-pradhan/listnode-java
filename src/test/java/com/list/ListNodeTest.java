package com.list;
import com.list.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class ListNodeTest {
    int[] rawData;

    @Nested
    class Initialization {
        @Test
        public void valShouldBeNullWhenNoParametersArePassed(){
            var node = new ListNode();
            assertEquals(0, node.val);
        }

        @Test
        public void nextShouldBeNullWhenNoParametersArePassed(){
            var node = new ListNode();
            assertEquals(null, node.next);
        }

        @Test
        public void valShouldBeOneWhenOneIsPassed(){
            var node = new ListNode(1);
            assertEquals(1, node.val);
        }

        @Test
        public void nextShouldBeNullWhenSecondParameterIsSkipped(){
            var node = new ListNode(1);
            assertEquals(null, node.next);
        }

        @Test
        public void valShouldBeOneWhenOneIsPassedAsFirstParameter(){
            var nextNode = new ListNode();
            var node = new ListNode(1,nextNode);
            assertEquals(1, node.val);
        }

        @Test
        public void nextNodeShouldBeLinkedWhenANodeIsPassedInSecondParameter(){
            var nextNode = new ListNode();
            var node = new ListNode(1,nextNode);
            assertEquals(nextNode, node.getNext());
        }
    }

    @Nested
    class WhenConstructLinkedListIsCalled{
        @Test
        public void headShouldBeNullWhenInputArrayIsEmpty(){ rawData = new int[] {}; }

        @Nested
        class AndWhenFourItemsOfRawDataIsPassed{
            ListNode head;

            @BeforeEach
            public void setUp(){
                rawData = new int[] { 1, 2, 3, 4 };
                head = new ListNode(rawData[0]);
                head.constructLinkedList(rawData, head, 0);
            }

            @Test
            public void headShouldBeOneWhen(){ assertEquals(1, head.val); }

            @Test
            public void secondItemShouldBeTwo(){ assertEquals(2, head.next.val); }

            @Test
            public void thirdItemShouldBeThree(){ assertEquals(3, head.next.next.val); }

            @Test
            public void fourthItemShouldBeFour(){ assertEquals(4, head.next.next.next.val); }

            @Test
            public void fifthItemShouldNotBeReachable(){ assertEquals(null, head.next.next.next.next); }
        }
    }
}