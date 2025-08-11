# 작성 순서 - 바텀업 방식
## Entity → Repository → Service → Controller → Dto

1. 구조잡기
   (controller, repository, service, entity, dto)
2. Entity & Repository 생성
movie 엔티티
   (@Getter, @Entity, @NoArgsConstructor, @Id, @GeneratedValue(starategy = GenerationType.IDENTITY))
review 엔티티
   (@ManyToOne과 @JoinColumn은 항상 같이 다닌다!)


예외처리 궁금한 것
new EntityNotFoundException("Movie not found"));

오타 발견
1) @ResponseBody MovideRequest request
으로 수정 @RequestBody MovieRequest request
2) dd


궁금한 것
FetchType.LAZY 
FetchType.EAGER

nullable = false
nullable = true